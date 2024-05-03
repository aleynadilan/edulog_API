package pojos;

import java.io.Serializable;

public class ClassessPostPOJO implements Serializable {
	private boolean isActive;
	private int companyId;
	private int groupId;
	private int schoolId;
	private String name;

	public void setIsActive(boolean isActive){
		this.isActive = isActive;
	}

	public boolean isIsActive(){
		return isActive;
	}

	public void setCompanyId(int companyId){
		this.companyId = companyId;
	}

	public int getCompanyId(){
		return companyId;
	}

	public void setGroupId(int groupId){
		this.groupId = groupId;
	}

	public int getGroupId(){
		return groupId;
	}

	public void setSchoolId(int schoolId){
		this.schoolId = schoolId;
	}

	public int getSchoolId(){
		return schoolId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"ClassessPostPOJO{" + 
			"isActive = '" + isActive + '\'' + 
			",company_id = '" + companyId + '\'' + 
			",group_id = '" + groupId + '\'' + 
			",school_id = '" + schoolId + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}

	public ClassessPostPOJO(boolean isActive, int companyId, int groupId, int schoolId, String name) {
		this.isActive = isActive;
		this.companyId = companyId;
		this.groupId = groupId;
		this.schoolId = schoolId;
		this.name = name;
	}

	public ClassessPostPOJO(){

	}
}