public class ExamPreparation {

    public static void main(String [] args) {
         IntList a = new IntList(8,null);
         a = new IntList(6,a);
         a = new IntList(4,a);
         a = new IntList(2,a);
         a = new IntList(0,a);
         IntList b = new IntList(9,null);
         b = new IntList(7,b);
         b = new IntList(5,b);
         b = new IntList(3,b);
         b = new IntList(1,b);

         while(a != null) {
              IntList t = a.tail;
              a.tail = b.tail;
              b.tail = t;
              //a   = a.tail;
              //b   = b.tail;
              b   = a.tail;
              a   = t;
         }



    }
}


