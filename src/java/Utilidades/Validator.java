/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author willywes
 */
public class Validator {

    private final Map<String, String> errors = new HashMap<>();
    private final Map<String, String> rules = new HashMap<>();
    private final Map<String, String> message = new HashMap<>();
    private final Map<String, String> inputs = new HashMap<>();

    private HttpServletRequest request = null;

    public void addRule(String input, String value) {
        rules.put(input, value);
    }

    public void addMessage(String input, String value) {
        message.put(input, value);
    }

    public void validar(HttpServletRequest request) {
        this.request = request;
        this.init();
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public Map<String, String> getInputs() {
        return inputs;
    }

    private void init() {
        processRequest();

        inputs.entrySet().forEach((entry) -> {
            System.out.println(entry.getKey() + " - " + entry.getValue());
            processRules(entry.getKey(), entry.getValue());
        });

        errors.entrySet().forEach((entry) -> {
            //System.out.println(entry.getKey() + " - " + entry.getValue());
        });

    }

    private void processRules(String input, String value) {

        try {

            String params = rules.get(input);

            if (!params.isEmpty()) {

                String[] types = params.split("\\|");

                for (String rule : types) {
                    //System.out.println(input  + " : " + rule + " : " + value);

                    if (rule.startsWith("require")) {
                        validateEmpty(value, input);
                    }

                    if (!value.isEmpty()) {

                        if (rule.startsWith("min")) {
                            String[] length = rule.split("\\:");
                            validateMinLength(value, length[1], input);
                        }

                        if (rule.startsWith("max")) {
                            String[] length = params.split("\\:");
                            validateMaxLength(value, length[1], input);
                        }
                        
                        if (rule.startsWith("email")) {
                            validateEmail(value, input);
                        }
                    }

                }

            }

        } catch (Exception e) {
            //System.out.println(e.getMessage());
        }

    }

    public void validateMinLength(String value, String length, String input) {
        int val = Integer.parseInt(length);

        if (value.length() < val) {
            String msg = message.get(input + ".min");

            if (msg == null) {
                msg = "El campo " + input + " debe tener como minimo " + length + " carácteres";
            }

            errors.put(input, msg);
        }

    }

    public void validateMaxLength(String value, String length, String input) {
        int val = Integer.parseInt(length);
        if (value.length() > val) {
            String msg = message.get(input + ".max");

            if (msg == null) {
                msg = "El campo " + input + " debe tener como máximo " + length + " carácteres";
            }

            errors.put(input, msg);
        }
    }

    public void validateEmail(String value, String input) {

        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        
        if(!matcher.matches()){
            String msg = message.get(input + ".max");

            if (msg == null) {
                msg = "El formato del campo " + input + " no es correcto.";
            }

            errors.put(input, msg);
        }

    }

    public void validateEmpty(String value, String input) {
        if (value.isEmpty()) {

            String msg = message.get(input + ".required");

            if (msg == null) {
                msg = "El campo " + input + " es obligtorio.";
            }

            errors.put(input, msg);
            // crear un metodo para buscar por input.required ejemplo
        }

    }

    public void processRequest() {

        Enumeration e = request.getParameterNames();

        while (e.hasMoreElements()) {
            Object obj = e.nextElement();
            String fieldName = (String) obj;
            String fieldValue = request.getParameter(fieldName);
            inputs.put(fieldName, fieldValue);
        }
    }

}
