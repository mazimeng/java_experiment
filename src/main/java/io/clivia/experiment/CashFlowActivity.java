package io.clivia.experiment;

public enum CashFlowActivity {
    ACCOUNTING("审计费"),
    ADMINISTRATION_FEE("管理费"),
    BONUS("分红"),
    COMPENSATION("补偿款"),
    CONFERENCE("会议"),
    CUSTODIAN("托管费"),
    DISCUSSION("讨论"),
    DIVIDEND("股息"),
    INTEREST("利息"),
    INVESTIGATION("尽职调查"),
    INVESTMENT("投资款"),
    INVESTOR_INVESTMENT("投资者出资款"),
    INVESTOR_PROFIT_ALLOC("投资者收益分配"),
    LEGAL("律师费"),
    MEETING("接洽"),
    MEMO("备忘"),
    MERGER_AND_ACQUISITION("股权转让所得-并购"),
    MILESTONE("大事记"),
    MISC("其它"),
    PHONE("电话沟通"),
    PROJECT_BONUS("项目分红"),
    PROJECT_COMPENSATION("项目补偿款"),
    PROJECT_DIVIDEND("项目股息"),
    PROJECT_INTEREST("项目利息"),
    PROJECT_INVESTMENT("项目投资款"),
    PROJECT_MERGER_AND_ACQUISITION("项目股权转让所得-并购"),
    PROJECT_REPURCHASE("项目股权转让所得-回购"),
    PROJECT_TRADE("项目股权转让所得-二级市场出售"),
    REPURCHASE("股权转让所得-回购"),
    SERVICE_FEE("行政服务费"),
    STUDY("学习"),
    SUPERVISION_FEE("账户监督费用"),
    SURVEY("企业调查"),
    TAX("税费"),
    TRADE("股权转让所得-二级市场出售"),
    VISITING("拜访");

    private String text;

    CashFlowActivity(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
