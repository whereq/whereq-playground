package com.fedex.sample.model;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.fedex.framework.util.JsonConverter;
import com.fedex.sample.model.entity.TicketEntity;
import com.fedex.sample.model.value.Ticket;

@Mapper(componentModel = "spring", uses = {JsonConverter.class})
public interface TicketMapper {
    @Mapping(source="ticketId", target="id")
    @Mapping(source="ticketTitle", target="title")
    @Mapping(source="ticketDetail", target="detail")
    @Mapping(source="ticketProps", target="props", qualifiedByName = {"JsonConverter", "toMap"} )
    @Mapping(source="ticketStatus", target="status")
    @Mapping(source="createdById", target="createdBy")
    @Mapping(source="createdEpochNbr", target="createdEpoch")
    @Mapping(source="updatedById", target="updatedBy")
    @Mapping(source="updatedEpochNbr", target="updatedEpoch")
    @Mapping(source="versionNbr", target="version")
    Ticket toTicket(TicketEntity entity);

    @InheritConfiguration(name = "toTicket")
    @Named("ticketWithoutDetail")
    @Mapping(target="detail", ignore = true)
    Ticket toTicketWithoutDetail(TicketEntity entity);
    
    @IterableMapping(qualifiedByName="ticketWithoutDetail")
    List<Ticket> toTickets(List<TicketEntity> entities);

    @InheritInverseConfiguration(name = "toTicket")
    @Mapping(source = "props", target = "ticketProps", qualifiedByName = {"JsonConverter", "toJson"})
    @Mapping(target="ticketStatus", ignore=true)
    @Mapping(target="createdEpochNbr", ignore=true)
    @Mapping(target="updatedEpochNbr", ignore=true)
    @Mapping(target="versionNbr", ignore=true)
    TicketEntity toTicketEntity(Ticket ticket);
    
    @InheritConfiguration(name = "toTicketEntity")
    @Mapping(target="ticketStatus", expression = "java(TicketStatus.DRAFT.name())")
    @Mapping(target="ticketId", ignore=true)
    @Mapping(target="updatedById", ignore=true)
    TicketEntity toNewTicketEntity(Ticket ticket);

    @InheritConfiguration(name = "toTicketEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TicketEntity patchTicketEntity(@MappingTarget TicketEntity entity,  Ticket ticket);
}
