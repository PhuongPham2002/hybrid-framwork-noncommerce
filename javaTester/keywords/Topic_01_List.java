package keywords;



public class Topic_01_List {
    public static void main(String[] args) {
        //Biểu thức điều kiện
        //if if-else if-else-if
        //switch case - không trùng lặp
      String browserName ="Chrome";
      switch (browserName) {
          case "Chrome":
              System.out.println("Chrome Browser");
              break;
          case "Firefox":
              System.out.println("Firefox");
              break;
          case "Edge":
              System.out.println("Edge");
          default: //Trình duyệt còn lại
              System.out.println("Safari");
      }

        //Biểu thức vòng lặp
        //for
        for (int i =0; i<5; i++) {
            System.out.println(i);
        }
        //while  --> kiểm tra điều kiện trc sau đó mới vào thực hiện action
        int x = 0;
        while(x <5) {
            System.out.println(x);
            x++;
        }
        //do-while  --> action trc rồi mới ktra điều kiện sau
        x=5;
        do {
            System.out.println(x);
            x++;
        } while (x < 5);
    }
}
