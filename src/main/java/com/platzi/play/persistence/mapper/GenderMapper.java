package com.platzi.play.persistence.mapper;

import com.platzi.play.domain.Gender;
import org.mapstruct.Named;

public class GenderMapper {

    @Named("stringToGender")
    public static Gender stringToGender(String genero) {
        if (genero == null) return null;

        return switch (genero.toUpperCase()) {
            case "ACCION" -> Gender.ACTION;
            case "COMEDIA" -> Gender.COMEDY;
            case "DRAMA" -> Gender.DRAMA;
            case "ANIMADA" -> Gender.ANIMATED;
            case "TERROR" -> Gender.HORROR;
            case "CIENCIA_FICCION" -> Gender.SCI_FI;
            default -> null;
        };
    }

    @Named("genderToString")
    public static String genderToString(Gender gender) {
        if (gender == null) return null;

        return switch (gender) {
            case ACTION -> "ACCION";
            case COMEDY -> "COMEDIA";
            case DRAMA -> "DRAMA";
            case ANIMATED -> "ANIMADA";
            case HORROR -> "TERROR";
            case SCI_FI -> "CIENCIA_FICCION";
        };
    }
}