package com.blog.blog_app.services;

import com.blog.blog_app.data.dto.PostUpdateDto;
import com.blog.blog_app.data.model.Post;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mapDtoToPost(PostUpdateDto postUpdateDto, @MappingTarget Post post);
}
