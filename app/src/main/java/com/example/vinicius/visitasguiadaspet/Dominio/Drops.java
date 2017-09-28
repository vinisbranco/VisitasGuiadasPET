package com.example.vinicius.visitasguiadaspet.Dominio;

/**
 * Created by vinicius on 28/09/17.
 */

public class Drops {public static String getDrop() {

    StringBuilder sqlBuilder = new StringBuilder();
    sqlBuilder.append("DROP TABLE LOCAIS");
    return getDrop().toString();
}
}
