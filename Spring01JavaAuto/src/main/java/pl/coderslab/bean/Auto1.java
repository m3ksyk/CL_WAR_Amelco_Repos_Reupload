package pl.coderslab.bean;

import org.springframework.stereotype.Component;

@Component
public class Auto1 {
    Auto2 auto2;

    public Auto1(Auto2 auto2) {
        this.auto2 = auto2;
    }

    public Auto2 getAuto2() {
        return auto2;
    }

    public void setAuto2(Auto2 auto2) {
        this.auto2 = auto2;
    }
}
