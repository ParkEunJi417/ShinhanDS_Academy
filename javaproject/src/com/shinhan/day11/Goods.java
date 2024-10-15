package com.shinhan.day11;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Goods<K,M> {
	K kind;
	M model;
}
