package 高并发.锁的使用.Utils;

public enum  SixCountryEnum {
    ONE(1,"齐"),TWO(2,"楚"),
    THREE(3,"燕"),FOUR(4,"赵"),
    FIVE(5,"魏"),SIX(6,"韩");


    private Integer retCode;
    private String retMessage;

    public Integer getRetCode() {
        return retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    SixCountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public static SixCountryEnum forEach_Country(int index){
        SixCountryEnum[] myArray = SixCountryEnum.values();
        for(SixCountryEnum elements:myArray){
            if(index==elements.getRetCode()){
                return elements;
            }
        }
        return null;
    }
}
