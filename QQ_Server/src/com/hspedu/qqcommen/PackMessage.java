package com.hspedu.qqcommen;

public class PackMessage {
    private Message message;
    private PackMessage next;

    public Message getMessage() {
        return message;
    }

    public PackMessage(Message message, PackMessage next) {
        this.message = message;
        this.next = next;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public PackMessage getNext() {
        return next;
    }

    public void setNext(PackMessage next) {
        this.next = next;
    }

    public PackMessage() {
        this.message = new Message();
        this.next = null;
    }
}
