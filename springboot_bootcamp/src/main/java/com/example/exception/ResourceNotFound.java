package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{

	private static final long serialVersionUID = 1L;
    private String resouceName;
    private String fieldName;
    private Object fieldValue;
    
	public ResourceNotFound(String resouceName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s: '%s'",resouceName,fieldName,fieldValue));
		this.resouceName = resouceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getResouceName() {
		return resouceName;
	}

	public void setResouceName(String resouceName) {
		this.resouceName = resouceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
	
    
    
	
}

//Employee not found with id:'5'