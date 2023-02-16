/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitories.impl;

import DomainModels.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Responsitories.SanPhamRepository;
import Utilities.DBConnection;
import ViewModels.SanPhamResponse;

/**
 *
 * @author hangnt
 */
public class SanPhamRepositoryImpl implements SanPhamRepository {

    @Override
    public List<SanPhamResponse> getAll() {
        String query = """
                       SELECT sp.id, sp.ten_san_pham, dm.ten_danh_muc , sp.so_luong ,
                       sp.gia_nhap ,sp.gia_ban ,sp .mieu_ta 
                       FROM san_pham sp INNER JOIN
                       danh_muc dm ON sp.danh_muc_id  = dm.id  
                       """;
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<SanPhamResponse> listSanPhams = new ArrayList<>();
            while (rs.next()) {
                SanPhamResponse sanPham = new SanPhamResponse(rs.getString(1),
                        rs.getString(2), rs.getString(3), rs.getInt(4),
                        rs.getDouble(5), rs.getDouble(6), rs.getString(7));
                listSanPhams.add(sanPham);
            }
            return listSanPhams;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public SanPham getOne(String id) {
        String query = """
                       SELECT id, danh_muc_id, ten_san_pham, so_luong, gia_nhap,
                       gia_ban, mieu_ta
                       FROM WS_FA22_BL1.dbo.san_pham
                       WHERE id = ?
                       """;
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                SanPham sanPham = new SanPham(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4), rs.getDouble(5),
                        rs.getDouble(6), rs.getString(7));
                return sanPham;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(SanPham sanPham) {
        int check = 0;
        String sql = """
                    INSERT INTO WS_FA22_BL1.dbo.san_pham
                    (danh_muc_id, ten_san_pham, so_luong, gia_nhap, gia_ban, mieu_ta)
                    VALUES(?,?,?,?,?,?);
                    """;

        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, sanPham.getDanhMucID());
            ps.setObject(2, sanPham.getTenSanPham());
            ps.setObject(3, sanPham.getSoLuong());
            ps.setObject(4, sanPham.getGiaNhap());
            ps.setObject(5, sanPham.getGiaBan());
            ps.setObject(6, sanPham.getMieuTa());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(String id) {
        int check = 0;
        String sql = """
                    DELETE FROM WS_FA22_BL1.dbo.san_pham
                    WHERE id=?;
                    """;

        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(String id, SanPham sanPham) {
        int check = 0;
        String sql = """
                    UPDATE WS_FA22_BL1.dbo.san_pham
                    SET danh_muc_id= ?, ten_san_pham=?, so_luong=?, gia_nhap=?,
                    gia_ban=?, mieu_ta=?
                    WHERE id=?;
                    """;

        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, sanPham.getDanhMucID());
            ps.setObject(2, sanPham.getTenSanPham());
            ps.setObject(3, sanPham.getSoLuong());
            ps.setObject(4, sanPham.getGiaNhap());
            ps.setObject(5, sanPham.getGiaBan());
            ps.setObject(6, sanPham.getMieuTa());
            ps.setObject(7, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

}
