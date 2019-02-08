public class ProgressBar{
    public int length;
    public int current;
    ProgressBar(int length, int current){
        this.length = length;

    }
    public void setCurrent(int newCurrent) {
        if (newCurrent > length) {
            this.current = length;
        }
        else {
            this.current = newCurrent;
        }
    }
    public int getCurrent() {
        return current;
    }
    public void increaseCurrent() {
        if (current + 1 > length) {
            this.current = length;
        }
        else {
            this.current += 1;
        }
    }

    public String toString(){
        if (current == length) {
            return "Completed!";
        }
        return String.format("[%s / %s] Completed", current, length);
        
    }
    
    

}
