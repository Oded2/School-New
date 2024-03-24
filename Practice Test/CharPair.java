class CharPair {

    char ch1;
    char ch2;

    public CharPair(char ch1, char ch2) {
        this.ch1 = ch1;
        this.ch2 = ch2;
    }

    public boolean isSame(NumbersPair numbers){
        return false;
    }

    public boolean bothCapital(){
        return isCapital(ch1) == isCapital(ch2);
    }

    private boolean isCapital(char c){
        return c>='A' && c<='Z';
    }
}
