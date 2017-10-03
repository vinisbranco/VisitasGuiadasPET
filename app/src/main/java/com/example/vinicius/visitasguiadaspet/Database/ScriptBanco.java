package com.example.vinicius.visitasguiadaspet.Database;

/**
 * Created by vinicius on 28/09/17.
 */

public class ScriptBanco {

    public static String getCreateLocal(){

        StringBuilder sqlBuilder =  new StringBuilder();
        sqlBuilder.setLength(500);
        sqlBuilder.append("CREATE TABLE LOCAIS ( ");
        sqlBuilder.append("id         CHAR (5)      PRIMARY KEY ");
        sqlBuilder.append("UNIQUE ");
        sqlBuilder.append("NOT NULL, ");
        sqlBuilder.append("nSala      VARCHAR (10)  NOT NULL, ");
        sqlBuilder.append("nome       VARCHAR (50)  NOT NULL, ");
        sqlBuilder.append("numContato NUMBER (11), ");
        sqlBuilder.append("email      VARCHAR (100), ");
        sqlBuilder.append("tempVist   NUMBER (3)    NOT NULL, ");
        sqlBuilder.append("descricao  VARCHAR (500) ");
        sqlBuilder.append("); ");
        sqlBuilder.append("CREATE TABLE HORARIOS ( ");
        sqlBuilder.append("id            CHAR (5)     REFERENCES LOCAIS (id), ");
        sqlBuilder.append("idHor         CHAR (5)     PRIMARY KEY ");
        sqlBuilder.append("NOT NULL ");
        sqlBuilder.append("UNIQUE, ");
        sqlBuilder.append("DiaSem        VARCHAR (10), ");
        sqlBuilder.append("HorentradaMan TIME, ");
        sqlBuilder.append("HorsaidaMan   TIME, ");
        sqlBuilder.append("HorentradaTar TIME, ");
        sqlBuilder.append("HorsaidaTar   TIME ");
        sqlBuilder.append("); ");


        return sqlBuilder.toString();
    }
}
