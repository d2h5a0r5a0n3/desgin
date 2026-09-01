package com.learn.desgin.lld.parkinglot.service;

import com.learn.desgin.lld.parkinglot.model.ticket.EntryTicket;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class TicketService {
    private Map<UUID, EntryTicket> uuidEntryTicketMap = new HashMap<>();

    public void add(EntryTicket ticket) {
        uuidEntryTicketMap.put(ticket.getId(), ticket);
    }

    public EntryTicket get(UUID id) {
        return uuidEntryTicketMap.get(id);
    }
}
