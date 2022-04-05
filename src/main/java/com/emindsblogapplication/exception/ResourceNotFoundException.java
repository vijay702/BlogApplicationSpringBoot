package com.emindsblogapplication.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	private String resorceName;
	private String fieldName;
	private String fieldValue;
	public ResourceNotFoundException(String resorceName, String fieldName, String fieldValue) {
		super(String.format("%s not found with %s : '%s'", resorceName,fieldName,fieldValue ));
		this.resorceName = resorceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	public String getResorceName() {
		return resorceName;
	}
	public void setResorceName(String resorceName) {
		this.resorceName = resorceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	
	

}
