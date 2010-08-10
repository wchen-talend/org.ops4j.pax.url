package org.sonatype.aether;

/*
 * Copyright (c) 2010 Sonatype, Inc. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0, 
 * and you may not use this file except in compliance with the Apache License Version 2.0. 
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the Apache License Version 2.0 is distributed on an 
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */

import java.io.File;

/**
 * A piece of metadata that needs to be merged with any current metadata before installation/deployment.
 * 
 * @author Benjamin Bentmann
 */
public interface MergeableMetadata
    extends Metadata
{

    /**
     * Merges this metadata into the current metadata (if any). Note that this method will be invoked regardless whether
     * metadata currently exists or not.
     * 
     * @param current The path to the current metadata file, may not exist but must not be {@code null}.
     * @param result The path to the result file where the merged metadata should be stored, must not be {@code null}.
     * @throws RepositoryException If the metadata could not be merged.
     */
    void merge( File current, File result )
        throws RepositoryException;

    /**
     * Indicates whether this metadata has been merged.
     * 
     * @return {@code true} if the metadata has been merged, {@code false} otherwise.
     */
    boolean isMerged();

}
