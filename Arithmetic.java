// Mahir Ashab Enan
// CSE Homework 02

public class Arithmetic {
    public static void main(String[] args)
    {
        //Number of pairs of pants
        int numpants=3;

        //Cost per pair of pants
        double pantsPrice=34.98;

        //Total Cost of Pants
        double pantsCost=(double) (numpants * pantsPrice);
        //return String.format("%.2f", pantsCost);
        //System.out.println("Total Cost of pants without tax $" + String.format("%.2f", pantsCost));
        System.out.println(String.format("Total Cost of pants without tax $%.2f", pantsCost));

        //tax rate
        double paSalesTax=0.06;

        //Pants Cost after tax
        double totalpantsCost=pantsCost + (pantsCost * paSalesTax);
        //return String.format("%.2f", totalpantsCost);
        //System.out.println("Total Cost of pants with tax $" + String.format("%.2f", totalpantsCost));
        System.out.println(String.format("Total Cost of belts with tax $%.2f", totalpantsCost));

        //Sales tax for pants
        double pantsSalesTax=(totalpantsCost - pantsCost);
        //return String.format("%.2f", pantsSalesTax);
        //System.out.println("Sales tax for pants $" + String.format("%.2f", pantsSalesTax));
        System.out.println(String.format("Sales tax for pants $%.2f", pantsSalesTax));

        //Number of sweatshirts
        int numshirts=2;

        //Cost of sweatshirts
        double shirtsPrice=24.99;

        //Total Cost of sweatshirts
        double shirtsCost=(double) (numshirts * shirtsPrice);
        //return String.format("%.2f", shirtsCost);
        //System.out.println("Total Cost of shirts without tax $" + String.format("%.2f", shirtsCost));
        System.out.println(String.format("Total Cost of shirts without tax $%.2f", shirtsCost));

        //Sweatshirts Cost after tax
        double totalshirtsCost=shirtsCost + (shirtsCost * paSalesTax);
        //return String.format("%.2f", totalshirtsCost);
        //System.out.println("Total Cost of shirts with tax $" + String.format("%.2f", totalshirtsCost));
        System.out.println(String.format("Total Cost of shirts with tax $%.2f", totalshirtsCost));

        //Sales tax for sweatshirts
        double shirtsSalesTax=(totalshirtsCost - shirtsCost);
        //return String.format("%.2f", shirtsSalesTax);
        //System.out.println("Sales tax for shirts $" + String.format("%.2f", shirtsSalesTax));
        System.out.println(String.format("Sales tax for shirts $%.2f", shirtsSalesTax));
        
        //Number of belts
        int numbelts=1;

        //Cost of belts
        double beltsPrice=33.99;

        //Total Cost of belts
        double beltsCost=(double) (numbelts * beltsPrice);
        //return String.format("%.2f", beltsCost);
        //System.out.println("Total Cost of belts without tax $" + String.format("%.2f", beltsCost));
        System.out.println(String.format("Total Cost of belts without tax $%.2f", beltsCost));

        //Belts Cost after tax
        double totalbeltsCost= beltsCost + (beltsCost * paSalesTax);
        //return String.format("%.2f", totalbeltsCost);
        //System.out.println("Total Cost of belts with tax $" + String.format("%.2f", totalbeltsCost));
        System.out.println(String.format("Total Cost of belts with tax $%.2f", totalbeltsCost));

        //Sales tax for belts
        double beltsSalesTax= (totalbeltsCost - beltsCost);
        //return String.format("%.2f", beltsSalesTax);
        //System.out.println("Sales tax for belts $" + String.format("%.2f", beltsSalesTax));
        System.out.println(String.format("Sales tax for belts $%.2f", beltsSalesTax));

        //Total Cost before tax
        double totaltaxlessCost=(pantsCost + shirtsCost + beltsCost);
        System.out.println(String.format("Total Cost before tax $%.2f", totaltaxlessCost));

        //Total Cost with tax
        double totaltaxCost=(totalpantsCost + totalshirtsCost + totalbeltsCost);
        System.out.println(String.format("Total Cost with tax $%.2f", totaltaxCost));

        //Total Sales tax
        double totalsalestax=(pantsSalesTax + shirtsSalesTax + beltsSalesTax);
        System.out.println(String.format("Total Sales tax $%.2f", totalsalestax));

    }
}