
package Seguros.Calculo;



public abstract class CalculosHogar {
    private double primaBase;
    private double totalAdicionales;

    public double getPrimaBase() {
        return primaBase;
    }

    public void setPrimaBase(int primaBase) {
        this.primaBase = primaBase;
    }

    public double getTotalAdicionales() {
        return totalAdicionales;
    }

    public void setPrimaBase(double primaBase) {
        this.primaBase = primaBase;
    }

    public void setTotalAdicionales(double totalAdicionales) {
        this.totalAdicionales = totalAdicionales;
    }
    
    
    public abstract double calcularPrima();
}

