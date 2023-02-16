/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.SanPham;
import java.util.List;
import ViewModels.SanPhamResponse;

/**
 *
 * @author hangnt
 */
public interface SanPhamService {

    List<SanPhamResponse> getAllSanPham();

    SanPham getOneSanPham(String id);

    String addSanPham(SanPham sanPham);

    String updateSanPham(String id, SanPham sanPham);

    String deleteSanPham(String id);

}
