/////////////////////////////////////////////////////////////////////////
//
// © University of Southampton IT Innovation Centre, 2016
//
// Copyright in this software belongs to University of Southampton
// IT Innovation Centre of Gamma House, Enterprise Road,
// Chilworth Science Park, Southampton, SO16 7NS, UK.
//
// This software may not be used, sold, licensed, transferred, copied
// or reproduced in whole or in part in any manner or form or in or
// on any media by any person other than in accordance with the terms
// of the Licence Agreement supplied with the software, or otherwise
// without the prior written consent of the copyright owners.
//
// This software is distributed WITHOUT ANY WARRANTY, without even the
// implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
// PURPOSE, except where stated in the Licence Agreement supplied with
// the software.
//
//      Created By :            Robbie Anderson
//      Created Date :          2016-09-02
//      Created for Project :   OPERANDO
//
/////////////////////////////////////////////////////////////////////////

/*
 * @author ra16 <ra16@it-innovation.soton.ac.uk
 */

package eu.operando.core.cpcu.servlet.springwrappers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

/**
 * The Class OspSetting.
 */
@Generated("org.jsonschema2pojo")
public class OspSetting {

	/** The osp id. */
	private String ospId;
	
	/** The osp settings. */
	private List<OspSetting_> ospSettings = new ArrayList<OspSetting_>();
	
	/** The additional properties. */
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * Gets the osp id.
	 *
	 * @return The ospId
	 */
	public String getOspId() {
		return ospId;
	}

	/**
	 * Sets the osp id.
	 *
	 * @param ospId The osp_id
	 */
	public void setOspId(String ospId) {
		this.ospId = ospId;
	}

	/**
	 * Gets the osp settings.
	 *
	 * @return The ospSettings
	 */
	public List<OspSetting_> getOspSettings() {
		return ospSettings;
	}

	/**
	 * Sets the osp settings.
	 *
	 * @param ospSettings The osp_settings
	 */
	public void setOspSettings(List<OspSetting_> ospSettings) {
		this.ospSettings = ospSettings;
	}

	/**
	 * Gets the additional properties.
	 *
	 * @return the additional properties
	 */
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	/**
	 * Sets the additional property.
	 *
	 * @param name the name
	 * @param value the value
	 */
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
