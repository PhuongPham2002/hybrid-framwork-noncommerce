package keywords;
/**
 * abstract được dùng cho 1 class hoặc 1 hàm
 * Dùng để thể hiện tính chất trừu tượng của lập trình hướng đối tượng trong java
 * hàm abtract vẫn cung cấp tên hàm , kiểu dữ liệu trả về, tham số --> ko có phần thực thi --> phần thực thi này thì
 * các lớp con sẽ tự chạy nhưng cần đảm bảo các kiểu như trên. (hàm abstract định nghĩa cái gì đc làm, còn làm như nào thì tùy hàm con quyết định.
 */

public abstract class BasePage {
    //constructor rỗng
    //public BasePage () {}
    //constructor không rỗng, có tham số:
    public BasePage (String browserName){}
    //Abstract method
    public abstract boolean isPageDisplayed ();
    //non abstract method
    public void clickToElement() {

    }

/**
 * Default, Private, protected, public Phạm vi truy cập: bên ngoài có thể dùng đc hàm hay biến trong class này hay ko? trong package/ngoài package?
 * <br> Sử dụng được cả cho hàm và cho biến
 */
// Thuộc tính - properties/variables/field
    private String fullname; // Dùng duy nhất trong class, ko cho class truy cập
    String city; // Default thì dùng trong class này và class bên ngoài nhưng bắt buộc cùng package
    protected String address; // Cùng package và thông qua tính chất kế thừa, thằng nào kế thừa basepage thì mới dùng đc
    public String phoneNumber; // Dùng đc trong mọi trường hợp
    // Hàm/phương thức - method/function
    public void setFullname(){}
    void setCity() {}
    protected void setAddress(){}
    private void setPhoneNumber() {}


    // Exception là 1 class cơ bản trong Java, chưa hầu hết tất cả các lỗi ngoại lệ trong Java
    // Catch là khối để sử lý các lỗi - 1 try có thể có nhiều khối catch
    // Có khối finally để dọn dẹp tài nguyên
    // Try-catch để xử lý các lỗi mà mình có thể biết trước được để tránh làm fail chương trình
    public boolean isElementDisplayed(){
        try{
            //Happy case, ko gặp lỗi gì hết
        } catch (Exception e) {  //Khi chạy có bắn ra lỗi, nếu ko bắt lại thì làm cho test case fail
            throw new RuntimeException(e);

        }
        return false;
    }

}





