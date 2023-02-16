/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitories.impl;

import DomainModels.DanhMuc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Responsitories.DanhMucRepository;
import Utilities.DBConnection;

/**
 *
 * @author hangnt
 */
public class DanhMucRepositoryImpl implements DanhMucRepository {

    @Override
    public List<DanhMuc> getAll() {
        String query = """
                       SELECT id, ten_danh_muc
                       FROM WS_FA22_BL1.dbo.danh_muc;
                       """;
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<DanhMuc> listDanhMucs = new ArrayList<>();
            while (rs.next()) {
                listDanhMucs.add(new DanhMuc(rs.getString(1), rs.getString(2)));
            }
            return listDanhMucs;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

}
