/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author hangnt
 */
public class SanPhamResponse {

    private String sanPhamID;
    private String tenSanPham;
    private String tenDanhMuc;
    private int soLuong;
    private double giaNhap;
    private double giaBan;
    private String mieuTa;

    public SanPhamResponse() {
    }

    public SanPhamResponse(String sanPhamID, String tenSanPham, String tenDanhMuc, int soLuong, double giaNhap, double giaBan, String mieuTa) {
        this.sanPhamID = sanPhamID;
        this.tenSanPham = tenSanPham;
        this.tenDanhMuc = tenDanhMuc;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.mieuTa = mieuTa;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public String getMieuTa() {
        return mieuTa;
    }

    public void setMieuTa(String mieuTa) {
        this.mieuTa = mieuTa;
    }

    public String getSanPhamID() {
        return sanPhamID;
    }

    public void setSanPhamID(String sanPhamID) {
        this.sanPhamID = sanPhamID;
    }

    public Object[] toDataRow() {
        return new Object[]{tenSanPham, tenDanhMuc, soLuong, giaNhap, giaBan, mieuTa};
    }

}
