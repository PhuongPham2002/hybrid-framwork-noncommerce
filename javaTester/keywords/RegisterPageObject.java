package keywords;

/**
 * Class kế thừa interface thì dùng implements
 * <br> static có kiểu biến static và hàm static, trong cả 2 trường hợp này thì các class sử dụng đều có thể gọi được mà
 * không cần khởi tạo biến, hoặc hàm lên.
 */

public class RegisterPageObject implements IBrowser {

    final String fullName ="Automation FC";
    // Giá trị không thể ghi đè, tương tự với hàm hay class cũng vậy, nếu dùng với class thì
    //nó có nghĩa là ko thể kế thừa, mở rộng class này.

    @Override
    public void clickToElement() {

    }
}
