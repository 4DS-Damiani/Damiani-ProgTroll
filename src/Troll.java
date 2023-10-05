public class Troll {
    private int healthPoints;
    private String arma;
    private int livello;

    public Troll(int healthPoints, String arma, int livello) throws Exception{
        setHealthPoints(healthPoints);
        setArma(arma);
        setLivello(livello);
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public String getArma() {
        return arma;
    }

    public int getLivello() {
        return livello;
    }

    public void setHealthPoints(int healthPoints)throws Exception {
        if(healthPoints>0) {
            this.healthPoints = healthPoints;
        }else{
            throw new Exception ("I punti vita inseriti non sono validi");
        }
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public void setLivello(int livello)throws Exception {
        if(livello>-1) {
            this.livello = livello;
        }else{
            throw new Exception ("Il livello inserito non è valido");
        }
    }

    //Metodo per danneggiare il troll
    public void receiveDamage(int damage) throws Exception{
        if(damage<=0){
            throw new Exception ("Il danno inserito non è valido");
        }else{
            healthPoints -= damage;
        }
    }

    public String toString(){
        return ("Livello - Arma - Punti vita\n"+livello+" - "+arma+" - "+healthPoints);
    }
}

