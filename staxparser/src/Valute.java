public class Valute {
    private String Name;
    private String CharCode;
    private int Nominal;
    private double Value;
    private String ID;



    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCharCode() {
        return CharCode;
    }

    public void setCharCode(String charCode) {
        CharCode = charCode;
    }

    public int getNominal() {
        return Nominal;
    }

    public void setNominal(int nominal) {
        Nominal = nominal;
    }

    public double getValue() {
        return Value;
    }

    public void setValue(double value) {
        Value = value;
    }

    @Override
    public String toString() {
        //более читаемый вид выдаваемого List<>
        final char dm = (char) 34;
        return "{" + dm +"id" + dm + ":" + dm + ID + dm +
                "," + dm + "Name"+ dm+":" + dm +  Name + dm +
                ","+ dm + "CharCode" +dm +":" + dm + CharCode + dm +
                ","+ dm + "Nominal" + dm + ":" + dm + Nominal + dm +
                "," + dm +"Value" + dm +":" + dm + Value + dm +
                '}'+",";
//        return ID +","+ Name + ',' + CharCode +
//                "," + Nominal +
//                "," + Value ;
    }
}
