/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.za.tut;

/**
 *
 * @author andil
 */
public class Member {
    
  
    private String name;
    private String surname;
    private String idNo;
    private String gender;
    private String typeContract;
    private Boolean checkBox;

    public Member(String name, String surname, String idNo, String gender, String typeContract, Boolean checkBox) {
        this.name = name;
        this.surname = surname;
        this.idNo = idNo;
        this.gender = gender;
        this.typeContract = typeContract;
        this.checkBox = checkBox;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTypeContract() {
        return typeContract;
    }

    public void setTypeContract(String typeContract) {
        this.typeContract = typeContract;
    }

    public Boolean getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(Boolean checkBox) {
        this.checkBox = checkBox;
    }

    @Override
    public String toString() {
        return "Member{" + "name=" + name + ", surname=" + surname + ", idNo=" + idNo + ", gender=" + gender + ", typeContract=" + typeContract + ", checkBox=" + checkBox + '}';
    }
    
    
}
