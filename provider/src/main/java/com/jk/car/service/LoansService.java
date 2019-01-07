package com.jk.car.service;

import com.jk.car.model.BorrowerBean;

/**
 * 金融Service接口
 */
public interface LoansService {
    /**
     * 新增贷款人
     * @param borrower
     */
    void saveBorrwer(BorrowerBean borrower);

}
