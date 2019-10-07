### JAVA
여기는 밑도 끝도 없이 알게된 토막지식을 정리하는 곳 ㅠㅠ

##### boolean과 Boolean의 Getter
```
public class Sample {
    private boolean enable;
    private Boolean disable;
    ..... 생략 ....

    public boolean isEnable() {   // <--- 통상적으로 primitive type은 isXxx()로 getter를 만듦
        return this.enable;
    }
    
    public Boolean getDisable() {   // <--- Wrapper Class는 null도 소유할 수 있기 때문에 통상 getXxx로 만든다고...
        return this.disable;
    }
}
```