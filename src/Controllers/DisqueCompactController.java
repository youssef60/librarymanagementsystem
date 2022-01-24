/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Dao.DisqueCompactDao;
import Models.DisqueCompactModel;
import Models.ResultSetModel;
import Util.ValidationUtil;

/**
 *
 * @author MHD
 */
public class DisqueCompactController {
    DisqueCompactModel disque = new DisqueCompactModel();
    DisqueCompactDao dao = new DisqueCompactDao();
    ResultSetModel model = new ResultSetModel();
    ValidationUtil validation = new ValidationUtil(); 

    public DisqueCompactModel getDisque() {
        return disque;
    }

    public DisqueCompactDao getDao() {
        return dao;
    }

    public ResultSetModel getModel() {
        return model;
    }

    public ValidationUtil getValidation() {
        return validation;
    }

    public void setDisque(DisqueCompactModel journal) {
        this.disque = journal;
    }

    public void setDao(DisqueCompactDao dao) {
        this.dao = dao;
    }

    public void setModel(ResultSetModel model) {
        this.model = model;
    }

    public void setValidation(ValidationUtil validation) {
        this.validation = validation;
    }



}
