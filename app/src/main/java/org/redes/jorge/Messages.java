package org.redes.jorge;

/**
 *
 * @author alsorc
 * Mensaje que la vista envía hacia el sensor
 */

public enum Messages {
    
    MOVIL_LIGHT_ON("MOVIL:LIGHT:ON"), MOVIL_LIGHT_OFF("MOVIL:LIGHT:OFF"),
    MOVIL_PRESENCE_ON("MOVIL:PRESENCE:ON"), MOVIL_PRESENCE_OFF("MOVIL:PRESENCE:OFF"), MOVIL_PRESENCE_ANALIZAR("MOVIL:PRESENCE:ANALIZAR"),
    MOVIL_SOUND_ON("MOVIL:SOUND:ON"), MOVIL_SOUND_OFF("MOVIL:SOUND:OFF"), MOVIL_SOUND_ANALIZAR("MOVIL:SOUND:ANALIZAR");
    
    private String value;
    
    Messages(String value){
        this.value = value;
    }
    
    public String getValue(){
        return this.value;
    }
}


