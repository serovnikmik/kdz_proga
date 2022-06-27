package web.models;

import org.springframework.stereotype.Component;

@Component
public class TopUpQuantity {

    private int value;

    public TopUpQuantity(){
        this.value = 0;
    }

    public TopUpQuantity(int value){
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
