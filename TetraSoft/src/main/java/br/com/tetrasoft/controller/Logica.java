package br.com.tetrasoft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {
	String executa(HttpServletRequest req,
            HttpServletResponse res) throws Exception;
}
