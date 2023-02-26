package com.example.warehouse.projection;

import com.example.warehouse.entity.Attachment;
import com.example.warehouse.entity.Category;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Attachment.class)
public interface CustomAttachment {
    Integer getId();
    String getName();
    String getSize();
    String getContentType();
}
