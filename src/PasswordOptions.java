public class PasswordOptions {
    int length; //length of password
    boolean uppercase;
    boolean lowercase;
    boolean numbers;
    boolean symbols;

     PasswordOptions(){
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isUppercase() {
        return uppercase;
    }

    public void setUppercase(boolean uppercase) {
        this.uppercase = uppercase;
    }

    public boolean isLowercase() {
        return lowercase;
    }

    public void setLowercase(boolean lowercase) {
        this.lowercase = lowercase;
    }

    public boolean isNumbers() {
        return numbers;
    }

    public void setNumbers(boolean numbers) {
        this.numbers = numbers;
    }

    public boolean isSymbols() {
        return symbols;
    }

    public void setSymbols(boolean symbols) {
        this.symbols = symbols;
    }
}
