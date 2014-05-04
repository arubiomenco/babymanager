package com.arubiomenco.babyman.services.sdo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Angel
 */
@XmlRootElement
public class BabySdo {
    private String name;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}