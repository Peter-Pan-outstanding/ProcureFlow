package wtc.ProcureFlow.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@RestController
@RequestMapping("/visualization")
public class VisualizationController {

    // 1. 能耗总览仪表盘数据
    @GetMapping("/energyOverview")
    public Map<String, Object> getEnergyOverview() {
        Map<String, Object> data = new HashMap<>();
        data.put("electricity", 12345);
        data.put("water", 5432);
        data.put("carbonEmission", 6789);
        return data;
    }

    // 2. 能耗占比环状图数据
    @GetMapping("/energyProportion")
    public Map<String, Object> getEnergyProportion() {
        Map<String, Object> data = new HashMap<>();
        data.put("totalEnergy", 20000);
        data.put("officeElectricity", 5000);
        data.put("officeWater", 3000);
        data.put("productionElectricity", 7000);
        data.put("productionWater", 5000);

        List<Map<String, Object>> proportions = new ArrayList<>();
        proportions.add(createProportion("办公耗电", 5000, 25));
        proportions.add(createProportion("办公用水", 3000, 15));
        proportions.add(createProportion("生产用水", 5000, 25));
        proportions.add(createProportion("生产耗电", 7000, 35));

        data.put("proportions", proportions);
        return data;
    }

    private Map<String, Object> createProportion(String name, int value, int percentage) {
        Map<String, Object> proportion = new HashMap<>();
        proportion.put("name", name);
        proportion.put("value", value);
        proportion.put("percentage", percentage);
        return proportion;
    }

    // 3. 库存预警滚动表格数据
    @GetMapping("/inventoryWarning")
    public List<Map<String, Object>> getInventoryWarning() {
        List<Map<String, Object>> inventory = new ArrayList<>();
        inventory.add(createInventoryRow(1, "物料1", "仓库A", 100, "正常"));
        inventory.add(createInventoryRow(2, "物料2", "仓库B", 5, "不足"));
        inventory.add(createInventoryRow(3, "物料3", "仓库C", 300, "溢出"));
        return inventory;
    }

    private Map<String, Object> createInventoryRow(int id, String material, String warehouse, int stock, String status) {
        Map<String, Object> row = new HashMap<>();
        row.put("id", id);
        row.put("material", material);
        row.put("warehouse", warehouse);
        row.put("stock", stock);
        row.put("status", status);
        return row;
    }

    // 4. 数据总览
    @GetMapping("/dataOverview")
    public Map<String, Object> getDataOverview() {
        Map<String, Object> data = new HashMap<>();
        data.put("yearSales", 500000);
        data.put("monthSales", 40000);
        data.put("todaySales", 1000);
        data.put("yearCarbonEmission", 12000);
        data.put("monthCarbonEmission", 1000);
        data.put("todayCarbonEmission", 50);

        List<Map<String, Object>> carbonEmissionRank = new ArrayList<>();
        carbonEmissionRank.add(createEmissionRank(1, "设备A", 500, 5000));
        carbonEmissionRank.add(createEmissionRank(2, "设备B", 400, 4000));
        data.put("carbonEmissionRank", carbonEmissionRank);
        return data;
    }

    private Map<String, Object> createEmissionRank(int id, String device, int production, int carbonEmission) {
        Map<String, Object> rank = new HashMap<>();
        rank.put("id", id);
        rank.put("device", device);
        rank.put("production", production);
        rank.put("carbonEmission", carbonEmission);
        return rank;
    }

    // 5. 销售计划完成率
    @GetMapping("/salesCompletionRate")
    public Map<String, Object> getSalesCompletionRate() {
        Map<String, Object> data = new HashMap<>();
        List<Map<String, Object>> salesData = new ArrayList<>();
        salesData.add(createSalesData("2021-11", 10000, 9000, 0.9));
        salesData.add(createSalesData("2022-03", 20000, 15000, 0.75));
        data.put("salesData", salesData);
        return data;
    }

    private Map<String, Object> createSalesData(String month, int planned, int sold, double completionRate) {
        Map<String, Object> sales = new HashMap<>();
        sales.put("month", month);
        sales.put("planned", planned);
        sales.put("sold", sold);
        sales.put("completionRate", completionRate);
        return sales;
    }

    // 6. 销售统计
    @GetMapping("/salesStatistics")
    public Map<String, Object> getSalesStatistics() {
        Map<String, Object> data = new HashMap<>();
        List<Map<String, Object>> salesStats = new ArrayList<>();
        salesStats.add(createSalesStat("2022-11", 50000, 45000));
        salesStats.add(createSalesStat("2022-12", 60000, 55000));
        data.put("salesStats", salesStats);
        return data;
    }

    private Map<String, Object> createSalesStat(String month, int totalSales, int contractSales) {
        Map<String, Object> stat = new HashMap<>();
        stat.put("month", month);
        stat.put("totalSales", totalSales);
        stat.put("contractSales", contractSales);
        return stat;
    }

    // 7. 销售排名 (TOP 8)
    @GetMapping("/salesRanking")
    public List<Map<String, Object>> getSalesRanking() {
        List<Map<String, Object>> rankings = new ArrayList<>();
        rankings.add(createSalesRanking("公司A", 100000));
        rankings.add(createSalesRanking("公司B", 90000));
        return rankings;
    }

    private Map<String, Object> createSalesRanking(String companyName, int sales) {
        Map<String, Object> ranking = new HashMap<>();
        ranking.put("companyName", companyName);
        ranking.put("sales", sales);
        return ranking;
    }

    // 8. 生产统计
    @GetMapping("/productionStatistics")
    public List<Map<String, Object>> getProductionStatistics() {
        List<Map<String, Object>> production = new ArrayList<>();
        production.add(createProductionRow(1, "产品A", "型号X", "规格1", 100, 50, 30, 10));
        production.add(createProductionRow(2, "产品B", "型号Y", "规格2", 200, 150, 50, 30));
        return production;
    }

    private Map<String, Object> createProductionRow(int id, String product, String model, String specification, int stock, int produced, int pending, int carbonEmission) {
        Map<String, Object> row = new HashMap<>();
        row.put("id", id);
        row.put("product", product);
        row.put("model", model);
        row.put("specification", specification);
        row.put("stock", stock);
        row.put("produced", produced);
        row.put("pending", pending);
        row.put("carbonEmission", carbonEmission);
        return row;
    }
}

