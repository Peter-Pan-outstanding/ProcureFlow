CREATE TABLE outbound_request (
                                  id INT AUTO_INCREMENT PRIMARY KEY,         -- 出库申请编号
                                  document_number VARCHAR(255) NOT NULL,     -- 单据号
                                  status VARCHAR(20) NOT NULL,               -- 申请状态（未提交、待审核、已审核）
                                  applicant VARCHAR(255) NOT NULL,           -- 申请人
                                  apply_date DATETIME NOT NULL,              -- 申请日期
                                  approval_status VARCHAR(20) DEFAULT '待审核', -- 审核状态（通过、驳回、待审核）
                                  approver VARCHAR(255),                     -- 审核人
                                  approval_date DATETIME,                    -- 审核日期
                                  material_name VARCHAR(255) NOT NULL,       -- 物料名称
                                  quantity INT NOT NULL                      -- 出库数量
);

INSERT INTO outbound_request (document_number, status, applicant, apply_date, approval_status, approver, approval_date, material_name, quantity)
VALUES
    ('DOC20240226001', '未提交', '刘志强', '2024-02-25 10:15:00', '待审核', NULL, NULL, 'H型钢', 120),
    ('DOC20240226002', '待审核', '王建国', '2024-02-24 14:30:00', '待审核', NULL, NULL, '不锈钢螺栓', 500),
    ('DOC20240226003', '已审核', '陈晓东', '2024-02-23 09:00:00', '通过', '赵慧敏', '2024-02-23 15:45:00', '铜芯电缆', 300),
    ('DOC20240226004', '未提交', '张伟', '2024-02-26 08:20:00', '待审核', NULL, NULL, '铝合金板', 80),
    ('DOC20240226005', '已审核', '周凯', '2024-02-22 16:10:00', '驳回', '李雪', '2024-02-23 10:00:00', '工业润滑油', 50),
    ('DOC20240226006', '未提交', '黄永明', '2024-02-26 11:00:00', '待审核', NULL, NULL, '高强度螺母', 1000),
    ('DOC20240226007', '待审核', '宋明辉', '2024-02-25 09:45:00', '待审核', NULL, NULL, '建筑水泥', 500),
    ('DOC20240226008', '已审核', '马云飞', '2024-02-21 13:25:00', '通过', '沈丽娟', '2024-02-22 10:00:00', 'PVC管材', 400),
    ('DOC20240226009', '已审核', '刘德海', '2024-02-20 15:40:00', '通过', '王欣然', '2024-02-21 08:30:00', '防火涂料', 200),
    ('DOC20240226010', '未提交', '何志远', '2024-02-26 14:10:00', '待审核', NULL, NULL, '焊接钢管', 250);

INSERT INTO outbound_request (document_number, status, applicant, apply_date, approval_status, approver, approval_date, material_name, quantity)
VALUES
    ('DOC20240226007', '未提交', '李娜', '2024-02-26 13:45:00', '待审核', NULL, NULL, '钢板', 150),
    ('DOC20240226008', '待审核', '刘浩', '2024-02-25 17:30:00', '待审核', NULL, NULL, '液压油', 200),
    ('DOC20240226009', '已审核', '王敏', '2024-02-24 09:20:00', '通过', '陈晓东', '2024-02-24 14:00:00', '铜管', 250),
    ('DOC20240226010', '未提交', '杨俊', '2024-02-26 10:05:00', '待审核', NULL, NULL, '电缆桥架', 400),
    ('DOC20240226011', '待审核', '赵婷', '2024-02-22 13:25:00', '待审核', NULL, NULL, 'PVC管材', 300),
    ('DOC20240226012', '已审核', '徐伟', '2024-02-21 16:50:00', '通过', '李雪', '2024-02-22 09:30:00', '铝合金门窗', 500),
    ('DOC20240226013', '未提交', '孙丽', '2024-02-25 11:00:00', '待审核', NULL, NULL, '水泥', 600),
    ('DOC20240226014', '已审核', '吴涛', '2024-02-20 08:15:00', '通过', '赵慧敏', '2024-02-21 17:00:00', '方管', 100),
    ('DOC20240226015', '未提交', '何冰', '2024-02-23 14:45:00', '待审核', NULL, NULL, '砂石料', 200),
    ('DOC20240226016', '待审核', '张婷', '2024-02-25 12:00:00', '待审核', NULL, NULL, '电线', 350),
    ('DOC20240226017', '已审核', '朱豪', '2024-02-22 10:40:00', '通过', '李雪', '2024-02-23 14:00:00', '木板', 450),
    ('DOC20240226018', '未提交', '高飞', '2024-02-26 09:30:00', '待审核', NULL, NULL, '铁皮', 300),
    ('DOC20240226019', '待审核', '贾伟', '2024-02-24 17:55:00', '待审核', NULL, NULL, '塑料袋', 2000),
    ('DOC20240226020', '已审核', '邓华', '2024-02-22 18:10:00', '通过', '赵慧敏', '2024-02-23 11:00:00', '玻璃钢', 150),
    ('DOC20240226021', '未提交', '刘翔', '2024-02-25 14:30:00', '待审核', NULL, NULL, '锻造钢', 250),
    ('DOC20240226022', '待审核', '蔡艳', '2024-02-24 12:40:00', '待审核', NULL, NULL, '塑料管', 500),
    ('DOC20240226023', '已审核', '梁杰', '2024-02-20 11:25:00', '通过', '陈晓东', '2024-02-21 16:30:00', '冷轧钢板', 100),
    ('DOC20240226024', '未提交', '蒋丽', '2024-02-26 10:55:00', '待审核', NULL, NULL, '粘合剂', 400),
    ('DOC20240226025', '待审核', '孙涛', '2024-02-23 15:20:00', '待审核', NULL, NULL, '防腐漆', 250),
    ('DOC20240226026', '已审核', '韩冰', '2024-02-21 09:00:00', '通过', '李雪', '2024-02-22 13:10:00', '不锈钢管', 200),
    ('DOC20240226027', '未提交', '刘云', '2024-02-26 12:00:00', '待审核', NULL, NULL, '热轧钢板', 600);
