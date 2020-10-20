import data.*;
import furnitures.bedroom.*;
import furnitures.livingroom.Chair;
import furnitures.livingroom.Table;

import furnitures.office.*;
 


class FurnitureApp{

    public static void main(String []args){

        furnitures.livingroom.Chair chair=new furnitures.livingroom.Chair();  //Living room chair
        furnitures.livingroom.Table livingroomTable=new furnitures.livingroom.Table();  //Living room table

        //furnitures.bedroom.
        Bed bed=new furnitures.bedroom.Bed();       //Bedroom Bed

       furnitures.office.Table officetable=new furnitures.office.Table(); //office table
        furnitures.office.Chair officeChair=new  furnitures.office.Chair(); //office chair


       //data.
       List list=new List();
      // data.
       Table table=new Table();

        System.out.printf("The price of %s is %d\n",chair, chair.price());
        System.out.printf("The price of %s is %d\n",livingroomTable, livingroomTable.price());

        System.out.printf("The price of %s is %d\n",bed, bed.price());
        System.out.printf("The price of %s is %d\n",officetable, officetable.price());
        System.out.printf("The price of %s is %d\n",officeChair, officeChair.price());


        
     
        System.out.println("list is"+list);
        System.out.println("table list is"+table);



   
    }
}