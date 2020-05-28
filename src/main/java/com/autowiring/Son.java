package com.autowiring;

public class Son {

    private Father father;

    public Son(Father father){
        this.father = father;
    }

    public Father getFather() {
        return father;
    }

    public void setFather(Father father) {
        this.father = father;
    }

    public void getFirstName(){
        father.getFirstName();
    }
}
