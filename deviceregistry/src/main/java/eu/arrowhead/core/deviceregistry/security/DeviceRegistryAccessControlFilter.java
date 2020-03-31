package eu.arrowhead.core.deviceregistry.security;

import eu.arrowhead.common.CommonConstants;
import eu.arrowhead.common.CoreCommonConstants;
import eu.arrowhead.common.SecurityUtilities;
import eu.arrowhead.common.dto.shared.CertificateType;
import eu.arrowhead.common.security.CoreSystemAccessControlFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConditionalOnProperty(name = CommonConstants.SERVER_SSL_ENABLED, matchIfMissing = true)
public class DeviceRegistryAccessControlFilter extends CoreSystemAccessControlFilter {

    //=================================================================================================
    // assistant methods
    private final SecurityUtilities securityUtilities;

    @Autowired
    public DeviceRegistryAccessControlFilter(final SecurityUtilities securityUtilities) {this.securityUtilities = securityUtilities;}

    //-------------------------------------------------------------------------------------------------
    @Override
    protected void checkClientAuthorized(final String clientCN, final String method, final String requestTarget, final String requestJSON,
                                         final Map<String, String[]> queryParams) {

        if (requestTarget.contains(CommonConstants.ONBOARDING_URI) || requestTarget.contains(CommonConstants.OP_DEVICE_REGISTRY_UNREGISTER_URI)) {
            securityUtilities.authenticateCertificate(clientCN, requestTarget, CertificateType.AH_ONBOARDING);
            return;
        }

        super.checkClientAuthorized(clientCN, method, requestTarget, requestJSON, queryParams);
        final String cloudCN = getServerCloudCN();

        if (requestTarget.contains(CoreCommonConstants.MGMT_URI)) {
            // Only the local System Operator can use these methods
            checkIfLocalSystemOperator(clientCN, cloudCN, requestTarget);
        }
    }
}