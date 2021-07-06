/********************************************************************************
 * Copyright (c) 2020 AITIA
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   AITIA - implementation
 *   Arrowhead Consortia - conceptualization
 ********************************************************************************/

package eu.arrowhead.core.qos.manager.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import eu.arrowhead.common.database.entity.QoSReservation;
import eu.arrowhead.common.dto.internal.CloudResponseDTO;
import eu.arrowhead.common.dto.internal.GSDPollResponseDTO;
import eu.arrowhead.common.dto.shared.OrchestrationFormRequestDTO;
import eu.arrowhead.common.dto.shared.OrchestrationResultDTO;
import eu.arrowhead.common.dto.shared.SystemRequestDTO;
import eu.arrowhead.core.qos.manager.QoSManager;

public class DummyQoSManager implements QoSManager {
	
	//=================================================================================================
	// methods

	//-------------------------------------------------------------------------------------------------
	@Override
	public List<QoSReservation> fetchAllReservation() {
		return new ArrayList<>();
	}
	
	//-------------------------------------------------------------------------------------------------
	@Override
	public List<OrchestrationResultDTO> filterReservedProviders(final List<OrchestrationResultDTO> orList, final SystemRequestDTO requester) {
		return orList;
	}

	//-------------------------------------------------------------------------------------------------
	@Override
	public List<OrchestrationResultDTO> reserveProvidersTemporarily(final List<OrchestrationResultDTO> orList, final SystemRequestDTO requester) {
		return orList;
	}

	//-------------------------------------------------------------------------------------------------
	@Override
	public void confirmReservation(final OrchestrationResultDTO selected, final List<OrchestrationResultDTO> orList, final SystemRequestDTO requester) {
		// intentionally do nothing
	}

	//-------------------------------------------------------------------------------------------------
	@Override
	public List<OrchestrationResultDTO> verifyIntraCloudServices(final List<OrchestrationResultDTO> orList, final OrchestrationFormRequestDTO request) {
		return orList;
	}
	
	//-------------------------------------------------------------------------------------------------
	@Override
	public List<GSDPollResponseDTO> preVerifyInterCloudServices(final List<GSDPollResponseDTO> gsdList, final OrchestrationFormRequestDTO request) {
		return gsdList;
	}

	//-------------------------------------------------------------------------------------------------
	@Override
	public List<OrchestrationResultDTO> verifyInterCloudServices(final CloudResponseDTO targetCloud, final List<OrchestrationResultDTO> orList, final Map<String,String> qosRequirements,
																 final Map<String,String> commands) {
		return orList;
	}
}