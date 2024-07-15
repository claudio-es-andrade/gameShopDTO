package com.claudioESandrade.gameShop.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Invoice")
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInvoice;

    @Column(name = "inv_client")
    private String invoiceClientName;
    @Column(name = "inv_qty")
    private int invoiceOrderQty;
    @Column(name = "inv_game")
    private String invoiceGameName;
    @Column(name = "inv_price")
    private float invoiceTotalPrice;
    @Column(name = "inv_category")
    private String invoiceCategoryName;

    // Constructors
    public Invoice() { }

    public Invoice(String invoiceClientName, int invoiceOrderQty, String invoiceGameName, float invoiceTotalPrice, String invoiceCategoryName) {
        this.invoiceClientName    = invoiceClientName;
        this.invoiceOrderQty      = invoiceOrderQty;
        this.invoiceGameName      = invoiceGameName;
        this.invoiceTotalPrice    = invoiceTotalPrice;
        this.invoiceCategoryName  = invoiceCategoryName;
    }

    public Invoice(Long idInvoice,String invoiceClientName, int invoiceOrderQty, String invoiceGameName, float invoiceTotalPrice, String invoiceCategoryName) {
        this.idInvoice            = idInvoice;
        this.invoiceClientName    = invoiceClientName;
        this.invoiceOrderQty      = invoiceOrderQty;
        this.invoiceGameName      = invoiceGameName;
        this.invoiceTotalPrice    = invoiceTotalPrice;
        this.invoiceCategoryName  = invoiceCategoryName;
    }

    // Invoice as DTO:
    public Invoice(Category category, Client client, Game game, Order order){
        // (ID_INVOICE, INV_CLIENT, INV_QTY, INV_GAME, INV_PRICE, INV_CATEGORY)
        this.invoiceClientName     = client.getNameClient();
        this.invoiceOrderQty       = order.getQty();
        this.invoiceGameName       = game.getNameGame();
        this.invoiceTotalPrice     = game.getPrice() * order.getQty();
        this.invoiceCategoryName   = category.getNameCategory();

    }

    // Getters

    public Long getIdInvoice() {
        return idInvoice;
    }

    public String getInvoiceClientName() {
        return invoiceClientName;
    }

    public int getInvoiceOrderQty() {
        return invoiceOrderQty;
    }

    public String getInvoiceGameName() {
        return invoiceGameName;
    }

    public float getInvoiceTotalPrice() {
        return invoiceTotalPrice;
    }

    public String getInvoiceCategoryName() {
        return invoiceCategoryName;
    }

    // Setters
    public void setIdInvoice(Long idInvoice) {
        this.idInvoice = idInvoice;
    }

    public void setInvoiceClientName(String invoiceClientName) {
        this.invoiceClientName = invoiceClientName;
    }

    public void setInvoiceOrderQty(int invoiceOrderQty) {
        this.invoiceOrderQty = invoiceOrderQty;
    }

    public void setInvoiceGameName(String invoiceGameName) {
        this.invoiceGameName = invoiceGameName;
    }

    public void setInvoiceTotalPrice(float invoiceTotalPrice) {
        this.invoiceTotalPrice = invoiceTotalPrice;
    }

    public void setInvoiceCategoryName(String invoiceCategoryName) {
        this.invoiceCategoryName = invoiceCategoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invoice invoice)) return false;
        return getInvoiceOrderQty() == invoice.getInvoiceOrderQty() && Float.compare(getInvoiceTotalPrice(), invoice.getInvoiceTotalPrice()) == 0 && Objects.equals(getIdInvoice(), invoice.getIdInvoice()) && Objects.equals(getInvoiceClientName(), invoice.getInvoiceClientName()) && Objects.equals(getInvoiceGameName(), invoice.getInvoiceGameName()) && Objects.equals(getInvoiceCategoryName(), invoice.getInvoiceCategoryName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdInvoice(), getInvoiceClientName(), getInvoiceOrderQty(), getInvoiceGameName(), getInvoiceTotalPrice(), getInvoiceCategoryName());
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "idInvoice=" + idInvoice +
                ", invoiceClientName='" + invoiceClientName + '\'' +
                ", invoiceOrderQty=" + invoiceOrderQty +
                ", invoiceGameName='" + invoiceGameName + '\'' +
                ", invoiceTotalPrice=" + invoiceTotalPrice +
                ", invoiceCategoryName='" + invoiceCategoryName + '\'' +
                '}';
    }
}


