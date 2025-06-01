package com.rushikesh.bookMarkerApp.api;


import com.rushikesh.bookMarkerApp.domain.BookmarkDTO;
import com.rushikesh.bookMarkerApp.domain.BookmarkService;
import com.rushikesh.bookMarkerApp.domain.BookmarksDTO;
import com.rushikesh.bookMarkerApp.domain.CreateBookmarkRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {
    private final BookmarkService bookmarkService;

    @GetMapping
    public BookmarksDTO getBookmarks(@RequestParam(defaultValue = "1") Integer page,
                                     @RequestParam(defaultValue = "") String query) {
        if(query == null || query.trim().length() == 0) {
            return bookmarkService.getBookmarks(page);
        }
        return bookmarkService.searchBookmarks(query, page);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookmarkDTO createBookmark(@RequestBody @Valid CreateBookmarkRequest request) {
        return bookmarkService.createBookmark(request);
    }
}
