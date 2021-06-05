package com.company;

public class Word {
    private String word;
    private int numberSymbol;

    public Word(){
        super();
    }

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getNumberSymbol() {
        return numberSymbol;
    }

    public void setNumberSymbol(int numberSymbol) {
        this.numberSymbol = numberSymbol;
    }
}
