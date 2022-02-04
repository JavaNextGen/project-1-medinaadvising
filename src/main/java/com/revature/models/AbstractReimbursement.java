package com.revature.models;

import java.util.Objects;

/**
 * This AbstractReimbursement class defines a minimum functionality for
 * interacting with reimbursements in the ERS application.
 *
 * All reimbursements in this application must at least have:
 * <ul>
 *     <li>ID</li>
 *     <li>Status</li>
 *     <li>Author</li>
 *     <li>Resolver</li>
 *     <li>Amount</li>
 * </ul>
 *
 * Additional fields can be added to the concrete {@link com.revature.models.Reimbursement} class.
 *
 * @author Center of Excellence
 */
public class AbstractReimbursement {

    private int reimb_id;
    private Status reimb_status;
    private User reimb_author;
    private User reimb_resolver;
    private int reimb_amount;

    public AbstractReimbursement() {
        super();
    }

    public AbstractReimbursement(int reimb_id, Status reimb_status, User reimb_author, User reimb_resolver, int reimb_amount) {
        super();
        this.reimb_id = reimb_id;
        this.reimb_status = reimb_status;
        this.reimb_author = reimb_author;
        this.reimb_resolver = reimb_resolver;
        this.reimb_amount = reimb_amount;
    }

    public int getReimb_id() {
        return reimb_id;
    }

    public void setReimb_id(int reimb_id) {
        this.reimb_id = reimb_id;
    }

    public Status getReimb_status() {
        return reimb_status;
    }

    public void setReimb_status(Status reimb_status) {
        this.reimb_status = reimb_status;
    }

    public User getReimb_author() {
        return reimb_author;
    }

    public void setReimb_author(User reimb_author) {
        this.reimb_author = reimb_author;
    }

    public User getReimb_resolver() {
        return reimb_resolver;
    }

    public void setReimb_resolver(User reimb_resolver) {
        this.reimb_resolver = reimb_resolver;
    }

    public double getReimb_amount() {
        return reimb_amount;
    }

    public void setReimb_amount(int reimb_amount) {
        this.reimb_amount = reimb_amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractReimbursement that = (AbstractReimbursement) o;
        return reimb_id == that.reimb_id && Double.compare(that.reimb_amount, reimb_amount) == 0 && reimb_status == that.reimb_status && Objects.equals(reimb_author, that.reimb_author) && Objects.equals(reimb_resolver, that.reimb_resolver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reimb_id, reimb_status, reimb_author, reimb_resolver, reimb_amount);
    }

    @Override
    public String toString() {
        return "AbstractReimbursement{" +
                "reimb_id = " + reimb_id +
                ", reimb_status = " + reimb_status +
                ", reimb_author = " + reimb_author +
                ", reimb_resolver = " + reimb_resolver +
                ", reimb_amount = " + reimb_amount +
                '}';
    }
}
