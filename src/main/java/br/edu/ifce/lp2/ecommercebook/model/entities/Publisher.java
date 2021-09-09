package br.edu.ifce.lp2.ecommercebook.model.entities;

public class Publisher {
    private Long id;
    private String name;
    private String phone;

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }


    public void setId(Long id){
        this.id = id;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setName(String name){
        this.name = name;
    }


}
