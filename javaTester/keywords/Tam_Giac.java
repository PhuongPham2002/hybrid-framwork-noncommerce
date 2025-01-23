package keywords;

public class Tam_Giac implements Interface_Practice, Overlap_Interface {
    int dienTich;
    int chuVi;
    int theTich;

    @Override
    public void dienTich(int cd, int cr, int cc) {
        dienTich = (cd + cr) * cc;
        System.out.println(dienTich);
    }

    @Override
    public void theTich(int cs, int cc) {
        theTich = cs*cc;
        System.out.println(theTich);
    }

    @Override
    public void chuVi(int cd, int cr) {
        chuVi = (cd + cr) * 2;
        System.out.println(chuVi);
    }

    public static void main(String[] args) {
        Tam_Giac tinhToan = new Tam_Giac();
        tinhToan.dienTich(2, 3, 5);
        tinhToan.chuVi(2, 3);
        tinhToan.theTich(2,10);
    }
}
