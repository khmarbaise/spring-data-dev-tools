/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.release.issues.jira;

import lombok.Value;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.release.Streamable;

/**
 * Value object to bind REST responses to.
 * 
 * @author Mark Paluch
 */
@Value
class JiraReleaseVersions implements Streamable<JiraReleaseVersion> {

	int startAt, maxResults, total;
	List<JiraReleaseVersion> values = new ArrayList<>();

	public int getNextStartAt() {
		return startAt + values.size();
	}

	public boolean hasMoreResults() {
		return startAt + values.size() < total;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<JiraReleaseVersion> iterator() {
		return values.iterator();
	}
}